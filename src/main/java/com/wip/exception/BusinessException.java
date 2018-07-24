/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/23 14:39
 **/
package com.wip.exception;

import com.wip.utils.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统一异常类
 */
public class BusinessException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessException.class);

    protected String errorCode;
    protected String[] errorMessageArguments;
    protected APIResponse apiResponse;

    protected BusinessException() {
        this("");
    }

    public BusinessException(String message) {
        super(message);
        this.errorCode = "fail";
        this.errorMessageArguments = new String[0];
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "fail";
        this.errorMessageArguments = new String[0];
    }

    public static BusinessException withErrorCode(String errorCode) {
        BusinessException businessException = new BusinessException();
        businessException.errorCode = errorCode;
        return businessException;
    }

    public String getErrorCode() {
        return this.errorCode;
    }


}
