package br.com.customlib.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Parameter;
import java.util.Optional;

public interface SecurityResourceAspect {

    Optional<ResponseEntity<Object>> checkPermissionByType(String sourceId, String property, String type);

    default Object success(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        SecurityResource securityResource = signature.getMethod().getAnnotation(SecurityResource.class);

        Parameter[] parameters = signature.getMethod().getParameters();

        String sourceId = getSourceId(args, securityResource, parameters);

        String property = securityResource.property();
        String type = securityResource.type();

        Optional<ResponseEntity<Object>> forbidden = checkPermissionByType(sourceId, property, type);

        if (forbidden.isPresent()) {
            return forbidden.get();
        }

        return joinPoint.proceed();
    }

    private static String getSourceId(final Object[] args, final SecurityResource securityResource, final Parameter[] parameters) {
        String sourceId = null;
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            if (isPrimitive(parameter.getType())) {
                if (!securityResource.source().equalsIgnoreCase(parameter.getName())) {
                    continue;
                }
                sourceId = (String) args[i];
            }
        }
        return sourceId;
    }

    private static boolean isPrimitive(Class<?> clazz) {
        return clazz.isPrimitive() || clazz == String.class;
    }

}
