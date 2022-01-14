package com.ask.core.step2

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.assertj.core.api.Assertions.assertThatIllegalStateException
import org.junit.jupiter.api.Test

class PreconditionsTest {

    @Test
    fun `require true`() {
        require(true)
    }

    @Test
    fun `require false`() {
        assertThatIllegalArgumentException().isThrownBy {
            require(false)
        }
    }

    @Test
    fun `require false with message`() {
        val message = "require!!!"

        assertThatIllegalArgumentException().isThrownBy {
            require(false) {
                message
            }
        }.withMessage(message)
    }

    @Test
    fun requireNotNull() {
        val nullVal: String? = null

        assertThatIllegalArgumentException().isThrownBy {
            requireNotNull(nullVal)
        }
    }

    @Test
    fun `check true`() {
        check(true)
    }

    @Test
    fun `check false`() {
        assertThatIllegalStateException().isThrownBy {
            check(false)
        }
    }

    @Test
    fun `check false with message`() {
        val message = "require!!!"

        assertThatIllegalStateException().isThrownBy {
            check(false) {
                message
            }
        }.withMessage(message)
    }

    @Test
    fun checkNotNull() {
        val nullVal: String? = null

        assertThatIllegalStateException().isThrownBy {
            checkNotNull(nullVal)
        }
    }

    @Test
    fun error() {
        val message = "error!!!"

        assertThatIllegalStateException().isThrownBy {
            error(message)
        }.withMessage(message)
    }
}