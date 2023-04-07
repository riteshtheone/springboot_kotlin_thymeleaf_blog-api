package com.realtime.blog_api.utils.mapper

interface Mapper<E, D> {
    fun toDomain(entity: E): D
    fun toEntity(domain: D): E
}