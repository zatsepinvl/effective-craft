package com.solutionshub.solution.application.service

import com.solutionshub.solution.application.port.`in`.SolutionQuery
import com.solutionshub.solution.domain.Solution
import org.springframework.stereotype.Service
import java.util.*

@Service
private class SolutionQueryService : SolutionQuery {
    private val demoSolution = Solution(UUID.randomUUID().toString(), "solutions-hub", "Solutions Hub")

    override fun getSolutionById(id: String): Solution {
        return demoSolution
    }

    override fun getSolutionBySlug(slug: String): Solution {
        return demoSolution
    }
}