package io.swagger.inflector.utils;

import io.swagger.core.filter.SwaggerSpecFilter;
import io.swagger.model.ApiDescription;
import io.swagger.models.Model;
import io.swagger.models.Operation;
import io.swagger.models.parameters.Parameter;
import io.swagger.models.properties.Property;

import java.util.List;
import java.util.Map;

public class DefaultSpecFilter implements SwaggerSpecFilter {
    static final String HIDDEN = "x-inflector-hidden";

    @Override
    public boolean isOperationAllowed(Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
        if(operation.getVendorExtensions() != null && operation.getVendorExtensions().containsKey(HIDDEN)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isParamAllowed(Parameter parameter, Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
        if(parameter.getVendorExtensions() != null && parameter.getVendorExtensions().containsKey(HIDDEN)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isPropertyAllowed(Model model, Property property, String propertyName, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
        if(property.getVendorExtensions() != null && property.getVendorExtensions().containsKey(HIDDEN)) {
            return false;
        }
        return true;
    }
}
