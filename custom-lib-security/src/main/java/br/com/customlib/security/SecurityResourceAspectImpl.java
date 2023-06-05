package br.com.customlib.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class SecurityResourceAspectImpl implements SecurityResourceAspect {

    @Override
    public Object success(final ProceedingJoinPoint joinPoint) throws Throwable {
        return SecurityResourceAspect.super.success(joinPoint);
    }

    @Override
    public Optional<ResponseEntity<Object>> checkPermissionByType(final String sourceId, final String property, final String type) {
        return Optional.empty();
    }

}