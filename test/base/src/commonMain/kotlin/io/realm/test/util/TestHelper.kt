/*
 * Copyright 2021 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.test.util

import io.realm.Realm
import kotlin.random.Random
import kotlin.random.nextULong

object TestHelper {

    fun randomEmail(): String {
        return "${Random.nextULong()}@test.kotlin.realm.io"
    }

    fun randomPartitionValue(): String {
        return "partition-${Random.nextULong()}"
    }

    /**
     * Returns a random key from the given seed. Used by encrypted Realms.
     */
    fun getRandomKey(seed: Long? = null): ByteArray {
        val key = ByteArray(Realm.ENCRYPTION_KEY_LENGTH)
        if (seed != null) {
            Random(seed).nextBytes(key)
        } else {
            Random.nextBytes(key)
        }
        return key
    }
}
