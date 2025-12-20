// package com.example.demo.service.Impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.entity.ClaimRuleEntity;
// import com.example.demo.repository.ClaimRuleRepository;
// import com.example.demo.service.ClaimRuleService;

// import java.util.List;

// public class ClaimRuleServiceImpl implements ClaimRuleService {

//     private final ClaimRuleRepository ruleRepository;

    
//     public ClaimRuleServiceImpl(ClaimRuleRepository ruleRepository) {
//         this.ruleRepository = ruleRepository;
//     }

//     @Override
//     public ClaimRuleEntity addRule(ClaimRuleEntity rule) {
//         if (rule.getWeight() == null || rule.getWeight() < 0) {
//             throw new BadRequestException("weight must be >= 0");
//         }
//         return ruleRepository.save(rule);
//     }

//     @Override
//     public List<ClaimRuleEntity> getAllRules() {
//         return ruleRepository.findAll();
//     }
// }
