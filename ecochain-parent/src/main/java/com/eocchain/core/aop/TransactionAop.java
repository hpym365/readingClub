package com.eocchain.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

/**
 * @Author: Haben
 * @Description:
 * @Date: 2017-08-25 14:54
 * @Version: 1.0
 **/
@Aspect
public class TransactionAop {

    private static final Logger log = LoggerFactory.getLogger(TransactionAop.class);

    @Autowired
    PlatformTransactionManager transactionManager;

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Pointcut("execution(* com.eocchain..*.service..*.insert*(..))")
    public void insert() {
    }

    @Pointcut("execution(* com.eocchain..*.service..*.save*(..))")
    public void save() {
    }

    @Pointcut("execution(* com.eocchain..*.service..*.update*(..))")
    public void update() {
    }

    @Pointcut("execution(* com.eocchain..*.service..*.delete*(..))")
    public void delete() {
    }

    @Pointcut("execution(* com.eocchain..*.service..*.remove*(..))")
    public void remove() {
    }

    @Around("insert(),update(),delete(),save(),remove()")
    public void trancation(ProceedingJoinPoint pjp) {
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        log.debug("TransactionAop  begin trancation");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            transactionManager.rollback(transactionStatus);
            log.error("TransactionAop  rollback :{}",throwable.getMessage());
            throwable.printStackTrace();
        }
        transactionManager.commit(transactionStatus);
        log.debug("TransactionAop  commit trancation");
    }

}
