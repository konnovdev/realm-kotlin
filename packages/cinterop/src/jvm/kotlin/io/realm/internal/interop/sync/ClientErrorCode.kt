/*
 * Copyright 2022 Realm Inc.
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

package io.realm.internal.interop.sync

import io.realm.internal.interop.NativeEnumerated
import io.realm.internal.interop.realm_app_errno_client_e

actual enum class ClientErrorCode(actual val description: String, override val nativeValue: Int) : NativeEnumerated {
    RLM_APP_ERR_CLIENT_USER_NOT_FOUND("UserNotFound", realm_app_errno_client_e.RLM_APP_ERR_CLIENT_USER_NOT_FOUND),
    RLM_APP_ERR_CLIENT_USER_NOT_LOGGED_IN("UserNotLoggedIn", realm_app_errno_client_e.RLM_APP_ERR_CLIENT_USER_NOT_LOGGED_IN),
    RLM_APP_ERR_CLIENT_APP_DEALLOCATED("AppDeallocated", realm_app_errno_client_e.RLM_APP_ERR_CLIENT_APP_DEALLOCATED);

    actual companion object {
        actual fun fromInt(nativeValue: Int): ClientErrorCode {
            for (value in values()) {
                if (value.nativeValue == nativeValue) {
                    return value
                }
            }
            error("Unknown client error code: $nativeValue")
        }

        internal fun of(nativeValue: Int): ClientErrorCode {
            return fromInt(nativeValue)
        }
    }
}
