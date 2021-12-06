package com.softmoon.data.mapper

interface Mapper<E, D> {
    fun mapFromEntity(type: E): D
}