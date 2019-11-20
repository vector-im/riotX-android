/*
 * Copyright 2019 New Vector Ltd
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

package im.vector.riotx.features.login

import im.vector.matrix.android.api.auth.data.Credentials
import im.vector.matrix.android.api.auth.registration.RegisterThreePid
import im.vector.riotx.core.platform.VectorViewModelAction

sealed class LoginAction : VectorViewModelAction {
    data class UpdateServerType(val serverType: ServerType) : LoginAction()
    data class UpdateHomeServer(val homeServerUrl: String) : LoginAction()
    data class UpdateSignMode(val signMode: SignMode) : LoginAction()
    data class Login(val login: String, val password: String, val initialDeviceName: String) : LoginAction()
    data class WebLoginSuccess(val credentials: Credentials) : LoginAction()
    data class InitWith(val loginConfig: LoginConfig) : LoginAction()
    data class ResetPassword(val email: String, val newPassword: String) : LoginAction()

    // Register actions
    open class RegisterAction : LoginAction()

    data class RegisterWith(val username: String, val password: String, val initialDeviceName: String) : RegisterAction()
    data class AddThreePid(val threePid: RegisterThreePid) : RegisterAction()
    // TODO Confirm Email (from link in the email)
    data class ConfirmMsisdn(val code: String) : RegisterAction()
    data class CaptchaDone(val captchaResponse: String) : RegisterAction()
    object AcceptTerms : RegisterAction()
    object RegisterDummy : RegisterAction()

    // Reset actions
    open class ResetAction : LoginAction()

    object ResetHomeServerType : ResetAction()
    object ResetHomeServerUrl : ResetAction()
    object ResetSignMode : ResetAction()
    object ResetLogin : ResetAction()
    object ResetResetPassword : ResetAction()
}
