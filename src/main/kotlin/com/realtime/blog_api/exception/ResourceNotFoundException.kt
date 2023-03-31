package com.realtime.blog_api.exception

class ResourceNotFoundException(resourceName: String, fieldName: String, fieldValue: Long) :
    RuntimeException(String.format("%s not found with %s : %l", resourceName, fieldName, fieldValue))
