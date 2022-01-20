package com.ask.core

class BackingProperties(
    private var _sample: Sample,
) {

    val sample
        get() = _sample

    fun updateSample(sample: Sample) {
        _sample = sample
    }
}

data class Sample(var name: String)
