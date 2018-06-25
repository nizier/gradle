package d1;

import d1.domain.CHECK_CONFIG;
import d1.domain.CHECK_CONFIGMapper;
import d1.domain.QUESTIONMapper;
import d1.service.CheckConfigService;
import d1.service.CheckService;
import d1.web.DeleteDataController;
import d1.web.TaskController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;



@Component
@EnableScheduling
public class ScheduleTask  implements SchedulingConfigurer {
    public static String TASK_TIME = "2 1 0 * * ?";//缺省"0 1 2 * * ?"表示每天0点1分2秒执行,可动态修改
    //改完TASK_TIME之后,只能再执行一次任务之后才起作用,就是下下个时间点才有效
    @Autowired
    TaskController taskController;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 任务逻辑
                taskController.startTask(null);
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 任务触发，可修改任务的执行周期
              if(taskController.getCHECK_CONFIGMapper()!=null){
                  CHECK_CONFIG check_config= CheckConfigService.Instance().getConfigObj(taskController.getCHECK_CONFIGMapper(),"CheckTime");
                  if(check_config!=null)
                  {
                      TASK_TIME="0 1 "+check_config.getValue()+" * * ?";
                  }
              }

                CronTrigger trigger = new CronTrigger(TASK_TIME);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        });
    }
}
