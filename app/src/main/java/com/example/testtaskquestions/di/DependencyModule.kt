package com.example.testtaskquestions.di

import com.example.testtaskquestions.data.mapper.AnswerMapper
import com.example.testtaskquestions.data.repository.AnswersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DependencyModule {

    @Singleton
    @Provides
    fun provideRepository(
        answerMapper: AnswerMapper,
    ): AnswersRepository {
        return AnswersRepository(answerMapper)
    }
}