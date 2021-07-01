package com.effective.spring.graphql

import com.effective.spring.graphql.SolutionQuery
import com.effective.spring.graphql.Solution
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