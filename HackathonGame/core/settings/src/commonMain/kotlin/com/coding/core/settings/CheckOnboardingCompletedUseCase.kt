package com.coding.core.settings

class CheckOnboardingCompletedUseCase(
    private val settingsRepository: SettingsRepository
) {
    suspend operator fun invoke(): Boolean {
        return settingsRepository.isOnboardingCompleted()
    }
}