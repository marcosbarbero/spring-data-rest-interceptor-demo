package com.marcosbarbero.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import static org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST;

public class DecryptInterceptor implements WebRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DecryptInterceptor.class);

    /**
     * Intercept the execution of a request handler <i>before</i> its invocation.
     * <p>Allows for preparing context resources (such as a Hibernate Session)
     * and expose them as request attributes or as thread-local objects.
     *
     * @param request the current web request
     * @throws Exception in case of errors
     */
    @Override
    public void preHandle(WebRequest request) throws Exception {
        String customerId = request.getParameter("customerId");

        logger.info(customerId);

        if (customerId != null) {
            request.setAttribute("internalCustomerId", 100, SCOPE_REQUEST);
        }
    }

    /**
     * Intercept the execution of a request handler <i>after</i> its successful
     * invocation, right before view rendering (if any).
     * <p>Allows for modifying context resources after successful handler
     * execution (for example, flushing a Hibernate Session).
     *
     * @param request the current web request
     * @param model   the map of model objects that will be exposed to the view
     *                (may be {@code null}). Can be used to analyze the exposed model
     *                and/or to add further model attributes, if desired.
     * @throws Exception in case of errors
     */
    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    /**
     * Callback after completion of request processing, that is, after rendering
     * the view. Will be called on any outcome of handler execution, thus allows
     * for proper resource cleanup.
     * <p>Note: Will only be called if this interceptor's {@code preHandle}
     * method has successfully completed!
     *
     * @param request the current web request
     * @param ex      exception thrown on handler execution, if any
     * @throws Exception in case of errors
     */
    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }
}
