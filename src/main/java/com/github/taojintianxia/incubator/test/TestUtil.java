package com.github.taojintianxia.incubator.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUtil {

    private static Logger logger = LoggerFactory.getLogger(TestUtil.class);

    public static void printInvocationStack() {
        logger.error("调用generateShardingTableNames时 , startDate在endDate之后 - sharding");
        try {
            StackTraceElement[] traces = Thread.currentThread().getStackTrace();
            logger.error("startDate在endDate之后的调用方法的栈列表为 :");
            for (StackTraceElement traceElement : traces) {
                logger.error("方法名 : " + traceElement.getClassName() + "." + traceElement.getMethodName()
                        + " 代码行数 : line " + traceElement.getLineNumber());
            }
        } catch (Exception e) {
            logger.error("获取generateShardingTableNamesDuringPeriod中日期判断处的调用堆栈出错" + e);
        }
    }
}
