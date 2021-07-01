package com.effective.spring.graphql

import com.effective.spring.graphql.Solution

interface SolutionQuery {
    fun getSolutionById(id: String): Solution
    fun getSolutionBySlug(slug: String): Solution
}