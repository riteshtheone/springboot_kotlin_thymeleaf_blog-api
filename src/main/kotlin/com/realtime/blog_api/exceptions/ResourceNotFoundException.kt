package com.realtime.blog_api.exceptions

class ResourceNotFoundException(private var resourceName: String, private var fieldName: String, private var fieldValue: Int) :
    RuntimeException(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue))