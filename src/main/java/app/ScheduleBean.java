package app;

import java.io.Serializable;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import testcases.Testcase;


@Named
@RequestScoped
public class ScheduleBean implements Serializable {

    @Inject
    private ApplicationDAO dao;

    public ScheduleModel getModel() {
        ScheduleModel model = new DefaultScheduleModel();

        for (Testcase testcase : dao.getAllTestcases()) {
            if (testcase.getNextExecutionDate() == null) {
                continue;
            }
            model.addEvent(DefaultScheduleEvent.builder()
                    .title(testcase.getDescription())
                    .startDate(testcase.getNextExecutionDate())
                    .allDay(true)
                    .build());
        }

        return model;
    }
}