package app;

import java.io.Serializable;
import java.util.List;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import testplan.Testplan;


@Named
@ApplicationScoped
public class ScheduleBean implements Serializable {

    @Inject
    private ApplicationDAO dao;

    private ScheduleModel model;

    @PostConstruct
    public void init() {
        model = new DefaultScheduleModel();

        List<Testplan> plans = dao.getAllTestplans();
        for (Testplan plan : plans) {
            if (plan.getPlannedDate() == null || plan.getTestcase() == null) {
                continue;
            }

            String title = plan.getTestcase().getId() + ": " + plan.getTestcase().getDescription();

            model.addEvent(DefaultScheduleEvent.builder()
                    .title(title)
                    .startDate(plan.getPlannedDate())
                    .allDay(true)
                    .build());
        }
    }

    public ScheduleModel getModel() {
        return model;
    }
}