package com.github.br11.api.proxy

import kotlin.reflect.*

class ApiDownstreamPropertyConverter<A, T, R>(val prop: KMutableProperty1<T, A>, val converter: KFunction1<R, A>) : KMutableProperty1<T, R> {

    override fun invoke(p1: T): R {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val annotations: List<Annotation> = prop.annotations
    override val getter: KProperty1.Getter<T, R> get() = TODO("not implemented")
    override val isAbstract: Boolean = prop.isAbstract
    override val isConst: Boolean = prop.isConst
    override val isFinal: Boolean = prop.isFinal
    override val isLateinit: Boolean = prop.isLateinit
    override val isOpen: Boolean = prop.isOpen
    override val name: String = prop.name
    override val parameters: List<KParameter> = prop.parameters
    override val returnType: KType = prop.returnType
    override val setter: KMutableProperty1.Setter<T, R> get() = TODO("not implemented")
    override val typeParameters: List<KTypeParameter> = prop.typeParameters
    override val visibility: KVisibility? = prop.visibility

    override fun call(vararg args: Any?): R {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun callBy(args: Map<KParameter, Any?>): R {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(receiver: T): R {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDelegate(receiver: T): Any? {
        return prop.getDelegate(receiver)
    }

    override fun set(receiver: T, value: R) {
        prop.set(receiver, converter.invoke(value))
    }

    override fun toString(): String {
        return "{$converter=$prop}"
    }
}

fun <A : Any?, T : Any, R : Any> convert(conversion: Pair<KFunction1<R, A>, KMutableProperty1<T, A>>): KMutableProperty1<T, R> {
    return ApiDownstreamPropertyConverter<A, T, R>(conversion.second, conversion.first)
}