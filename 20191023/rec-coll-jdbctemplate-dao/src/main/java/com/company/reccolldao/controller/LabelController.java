package com.company.reccolldao.controller;

import com.company.reccolldao.dao.LabelDao;
import com.company.reccolldao.model.Label;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LabelController {
    private LabelDao labelDao;

    @RequestMapping(value = "/label", method = RequestMethod.GET)
    public List<Label> getAllLabels() {
        List<Label> labelList = labelDao.getAllLabels();
        return labelList;
    }

    @PostMapping(value = "/label")
    @ResponseStatus(HttpStatus.CREATED)
    public Label createNewLabel(@RequestBody Label label) {
        return labelDao.addLabel(label);
    }

    @RequestMapping(value = "/label/{id}", method = RequestMethod.GET)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public Label getLabelById(@PathVariable int id) {
        return labelDao.getLabel(id);
    }


    @RequestMapping(value = "/label/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabelById(@PathVariable int id) {
        labelDao.deleteLabel(id);
    }

    @PutMapping(value = "/label/{id}")
    public void updateLabel(Label label) {
        labelDao.updateLabel(label);
    }
}
