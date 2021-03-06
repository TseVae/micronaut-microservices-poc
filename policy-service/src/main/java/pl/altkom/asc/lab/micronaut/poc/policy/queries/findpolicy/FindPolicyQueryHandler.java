package pl.altkom.asc.lab.micronaut.poc.policy.queries.findpolicy;

import lombok.RequiredArgsConstructor;
import pl.altkom.asc.lab.micronaut.poc.policy.readmodel.PolicyView;
import pl.altkom.asc.lab.micronaut.poc.policy.readmodel.PolicyViewRepository;
import pl.altkom.asc.lab.micronaut.poc.policy.infrastructure.bus.QueryHandler;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.queries.findpolicy.FindPolicyQuery;
import pl.altkom.asc.lab.micronaut.poc.policy.service.api.v1.queries.findpolicy.FindPolicyQueryResult;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@RequiredArgsConstructor
public class FindPolicyQueryHandler implements QueryHandler<FindPolicyQueryResult, FindPolicyQuery> {

    private final PolicyViewRepository policyViewRepository;

    @Override
    public FindPolicyQueryResult handle(FindPolicyQuery query) {
        List<PolicyView> policies = policyViewRepository.findAll();

        return new FindPolicyQueryResult(
                policies.stream()
                        .map(PolicyListItemDtoAssembler::map)
                        .collect(Collectors.toList())
        );
    }


}
