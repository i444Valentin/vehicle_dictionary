package com.dictionary.vehicle.vehicle_dictionary.service.consumer;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Consumer;

/**
 * Класс, отвечающий за прием входных
 * критериев и преобразование их в запрос,
 * позволяющий получить данные из базы данных
 * на основе критериев
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleSearchQueryCriteriaConsumer implements Consumer<SearchCriteria> {

        private Predicate predicate;
        private CriteriaBuilder builder;
        private Root r;

        @Override
        public void accept(SearchCriteria param) {
            if (param.getOperation().equalsIgnoreCase(">")) {
                predicate = builder.and(predicate, builder
                        .greaterThanOrEqualTo(r.get(param.getKey()), param.getValue().toString()));
            } else if (param.getOperation().equalsIgnoreCase("<")) {
                predicate = builder.and(predicate, builder.lessThanOrEqualTo(
                        r.get(param.getKey()), param.getValue().toString()));
            } else if (param.getOperation().equalsIgnoreCase(":")) {
                if (r.get(param.getKey()).getJavaType() == String.class) {
                    predicate = builder.and(predicate, builder.like(
                            r.get(param.getKey()), "%" + param.getValue() + "%"));
                } else {
                    predicate = builder.and(predicate, builder.equal(
                            r.get(param.getKey()), param.getValue()));
                }
            }
        }
}

