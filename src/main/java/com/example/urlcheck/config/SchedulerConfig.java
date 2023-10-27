package com.example.urlcheck.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * Config class to enable spring scheduling tasks.
 */
@Configuration
@EnableScheduling
public class SchedulerConfig /* implements SchedulingConfigurer */ {

    // @Autowired
    // private TickService tickService;

    // @Bean
    // public Executor taskExecutor() {
    // return Executors.newSingleThreadScheduledExecutor();
    // }

    // @Override
    // public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    // // TODO Auto-generated method stub
    // taskRegistrar.setScheduler(taskExecutor());
    // taskRegistrar.addTriggerTask(
    // new Runnable() {
    // @Override
    // public void run() {
    // tickService.performUrlCheck();
    // }
    // },
    // new Trigger() {

    // @Override
    // public Date nextExecutionTime(TriggerContext context) {
    // Optional<Date> lastCompletionTime =
    // Optional.ofNullable(context.lastCompletionTime());
    // Instant nextExecutionTime =
    // lastCompletionTime.orElseGet(Date::new).toInstant().plusMillis(tickService.getTickInteger());
    // return Date.from(nextExecutionTime);
    // }

    // @Override
    // @Nullable
    // public Instant nextExecution(TriggerContext triggerContext) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'nextExecution'");
    // }
    // }
    // }

}
