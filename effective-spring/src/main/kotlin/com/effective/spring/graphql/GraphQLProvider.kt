package com.solutionshub.solution.adapter.`in`.web

import com.solutionshub.annotation.Resolver
import com.solutionshub.solution.application.port.`in`.SolutionQuery
import com.solutionshub.solution.domain.Solution
import graphql.kickstart.tools.GraphQLQueryResolver


@Resolver
class SolutionResolver(
    private val solutionQuery: SolutionQuery,
) : GraphQLQueryResolver {

    fun solutionById(id: String): Solution {
        return solutionQuery.getSolutionById(id)
    }

    fun solutionBySlug(id: String): Solution {
        return solutionQuery.getSolutionById(id)
    }
}