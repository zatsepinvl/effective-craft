package com.solutionshub.solution.application.port.`in`

import com.solutionshub.solution.domain.Solution

interface SolutionQuery {
    fun getSolutionById(id: String): Solution
    fun getSolutionBySlug(slug: String): Solution
}