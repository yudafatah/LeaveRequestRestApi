/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.leaverequestmaven.controller;

import com.mii.leaverequestmaven.DAO.EmployeeDAO;
import com.mii.leaverequestmaven.DAO.LeaveRequestDAO;
import com.mii.leaverequestmaven.model.Employee;
import com.mii.leaverequestmaven.model.LeaveRequest;
import com.mii.leaverequestmaven.model.LeaveRequestType;
import com.mii.leaverequestmaven.model.ServiceResponse;
import com.mii.leaverequestmaven.tools.EncodeFile;
import com.mii.leaverequestmaven.tools.countDate;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yudafatah
 */
@RestController
@RequestMapping("/lr")
public class LeaveRequestController {

    @Autowired
    LeaveRequestDAO lrdao;

    @Autowired
    EmployeeDAO edao;

    List<LeaveRequest> leaverequestList = new ArrayList<>();
    List<Object> leaverequestList1 = new ArrayList<>();
    List<HashMap<String, String>> lrList = new ArrayList<>();

    /* to save an employee*/
    @PostMapping("/leaverequests")
    public LeaveRequest createLeaveRequest(@Valid @RequestBody LeaveRequest request) {
        return lrdao.save(request);
    }

    /*get all employees*/
    @GetMapping("/leaverequests/{id}")
    public ResponseEntity<Object> getAllLeaveRequest(@PathVariable(value = "id") String lrid) {
        lrList.removeAll(lrList);
        for (LeaveRequest leaveRequest : lrdao.findAll()) {
            if (leaveRequest.getEmployeeId().getEmployeeId() == Integer.parseInt(lrid)) {
//                LeaveRequest lr = new LeaveRequest();
//                lr.setLrId(leaveRequest.getLrId());
//                lr.setRequestDate(leaveRequest.getRequestDate());
//                lr.setStartDate(leaveRequest.getStartDate());
//                lr.setEndDate(leaveRequest.getEndDate());
//                lr.setLrDuration(leaveRequest.getLrDuration());
//                lr.setNoteRequest(leaveRequest.getNoteRequest());
//                lr.setRequestStatus(leaveRequest.getRequestStatus());
//                String img = null;
//                byte[] bimg = leaveRequest.getImage();
//                img = new String(bimg);
//                lr.setImage(img.getBytes());
//                lr.setNoteReject(leaveRequest.getNoteReject());
//                lr.setEmployeeId(leaveRequest.getEmployeeId());
//                lr.setTypeLrId(leaveRequest.getTypeLrId());
                HashMap<String, String> lr = new HashMap<>();
                lr.put("lrId", leaveRequest.getLrId() + "");
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String reqDate = format.format(leaveRequest.getRequestDate());
                lr.put("requestDate", reqDate);
                lr.put("startDate", leaveRequest.getStartDate().toString());
                lr.put("endDate", leaveRequest.getEndDate().toString());
                lr.put("lrDuration", leaveRequest.getLrDuration() + "");
                lr.put("noteRequest", leaveRequest.getNoteRequest());
                lr.put("requestStatus", leaveRequest.getRequestStatus());
                String img = "x";
                if (leaveRequest.getImage() != null) {
                    byte[] bimg = leaveRequest.getImage();
                    img = new String(bimg);
                }
                lr.put("image", img);
                lr.put("noteReject", leaveRequest.getNoteReject());
                lr.put("empName", leaveRequest.getEmployeeId().getEmployeeName());
                lr.put("typeLr", leaveRequest.getTypeLrId().getTypeName());
                lrList.add(lr);
            }
        }
        ServiceResponse<List<HashMap<String, String>>> response = new ServiceResponse<>("success", lrList);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/leaverequestsrelation/{id}")
    public ResponseEntity<Object> getAllLeaveRequestRelation(@PathVariable(value = "id") String lrid) {
        leaverequestList1.removeAll(leaverequestList1);
        Employee e = edao.findOne(Integer.parseInt(lrid));
        for (Employee employee : e.getEmployeeList()) {
            for (LeaveRequest leaveRequest : employee.getLeaveRequestList()) {
                Object name = leaveRequest.getEmployeeId().getEmployeeName();
                leaverequestList1.add(name);
            }
        }
        ServiceResponse<List<Object>> response = new ServiceResponse<>("success", leaverequestList1);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    /*get all employees as manager*/
    @GetMapping("/leaverequestsmanager/{id}")
    public ResponseEntity<Object> getAllLeaveRequestManager(@PathVariable(value = "id") String lrid) {
        leaverequestList.removeAll(leaverequestList);
        Employee e = edao.findOne(Integer.parseInt(lrid));
        for (Employee employee : e.getEmployeeList()) {
            for (LeaveRequest leaveRequest : employee.getLeaveRequestList()) {
                leaverequestList.add(leaveRequest);
                System.out.println("");
            }
        }
        ServiceResponse<List<LeaveRequest>> response = new ServiceResponse<>("success", leaverequestList);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    /*get employee by empid*/
    @GetMapping("/leaverequest/{id}")
    public ResponseEntity<LeaveRequest> getLeaveRequestById(@PathVariable(value = "id") Integer lrid) {

        LeaveRequest lr = lrdao.findOne(lrid);

        if (lr == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(lr);
    }

    /*update an lr by lrid*/
    @PostMapping("/leaverequestapprove/{id}")
    public ResponseEntity<LeaveRequest> updateLeaveRequest(@PathVariable(value = "id") String lrid) {

        LeaveRequest lr = lrdao.findOne(Integer.parseInt(lrid));
        if (lr == null) {
            return ResponseEntity.notFound().build();
        }

        lr.setEmployeeId(lr.getEmployeeId());
        lr.setTypeLrId(lr.getTypeLrId());
        lr.setRequestDate(lr.getRequestDate());
        lr.setStartDate(lr.getStartDate());
        lr.setEndDate(lr.getEndDate());
        lr.setLrDuration(lr.getLrDuration());
        lr.setNoteRequest(lr.getNoteRequest());
        lr.setRequestStatus("Approved");
        lr.setImage(lr.getImage());
        lr.setNoteReject(lr.getNoteReject());

        LeaveRequest updateLeaveRequest = lrdao.save(lr);
        return ResponseEntity.ok().body(updateLeaveRequest);

    }

    /*update an lr by lrid*/
    @PostMapping("/leaverequestcancel/{id}")
    public ResponseEntity<LeaveRequest> cancelLeaveRequest(@PathVariable(value = "id") String lrid) {

        LeaveRequest lr = lrdao.findOne(Integer.parseInt(lrid));
        if (lr == null) {
            return ResponseEntity.notFound().build();
        }

        lr.setEmployeeId(lr.getEmployeeId());
        lr.setTypeLrId(lr.getTypeLrId());
        lr.setRequestDate(lr.getRequestDate());
        lr.setStartDate(lr.getStartDate());
        lr.setEndDate(lr.getEndDate());
        lr.setLrDuration(lr.getLrDuration());
        lr.setNoteRequest(lr.getNoteRequest());
        lr.setRequestStatus("Canceled");
        lr.setImage(lr.getImage());
        lr.setNoteReject(lr.getNoteReject());

        LeaveRequest updateLeaveRequest = lrdao.save(lr);
        return ResponseEntity.ok().body(updateLeaveRequest);

    }

    @PostMapping("/leaverequestcreate/{id}/{typelr}/{startdate}/{enddate}/{notereq}/{savePath}")
    public ResponseEntity<LeaveRequest> createLeaveRequest(@PathVariable(value = "id") String lrid,
            @PathVariable(value = "typelr") String typelr, @PathVariable(value = "startdate") String startdate,
            @PathVariable(value = "enddate") String enddate, @PathVariable(value = "notereq") String notereq,
            @PathVariable(value = "savePath") String savePath) throws ParseException, IOException, Exception {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//            Date requestDate = format.parse(reqDate);
        Date startDate = format.parse(startdate);
        Date endDate = format.parse(enddate);
        LocalDate localDate = LocalDate.now();
        Date reqdate = format.parse(localDate.toString());
        System.out.println(reqdate);
//        String foto = EncodeFile.upload(savePath);
//        byte[] b = foto.getBytes(Charset.forName("UTF-8"));
        int lrduration = countDate.countDays(startdate, enddate);

        LeaveRequest lr = new LeaveRequest(null, reqdate, startDate, endDate, lrduration, notereq, "Waiting", null, null, new Employee(Integer.parseInt(lrid)), new LeaveRequestType(Integer.parseInt(typelr)));

        LeaveRequest updateLeaveRequest = lrdao.save(lr);
        return ResponseEntity.ok().body(updateLeaveRequest);

    }

    /*Delete an employee*/
    @DeleteMapping("/leaverequest/{id}")
    public ResponseEntity<LeaveRequest> deleteLeaveRequest(@PathVariable(value = "id") Integer lrid) {

        LeaveRequest lr = lrdao.findOne(lrid);
        if (lr == null) {
            return ResponseEntity.notFound().build();
        }
        lrdao.delete(lr);

        return ResponseEntity.ok().build();

    }
}
