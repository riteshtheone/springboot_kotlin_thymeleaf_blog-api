package com.realtime.blog_api.exception

class ResourceNotFoundException(resourceName: String, fieldName: String, fieldValue: Int) :
    RuntimeException(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue))