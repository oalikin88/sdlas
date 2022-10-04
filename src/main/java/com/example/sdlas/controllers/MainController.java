/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.controllers;

import com.example.sdlas.SdlasApplication;
import com.example.sdlas.auth.AuthenticationService;
import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.exceptions.MyException;
import com.example.sdlas.mappers.JournalStorageMapper;
import com.example.sdlas.model.CommentDto;
import com.example.sdlas.model.SignDto;
import com.example.sdlas.model.JournalStorageDto;
import com.example.sdlas.model.ModelView;
import com.example.sdlas.repositories.JournalStorageRepo;
import com.example.sdlas.services.EditCommentService;
import com.example.sdlas.services.EmployeeService;
import com.example.sdlas.services.JournalStorageService;
import com.example.sdlas.services.SearchService;
import com.example.sdlas.services.SendMailService;
import com.example.sdlas.services.SignStorageService;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.opfr.springBootStarterDictionary.clientImpl.EmployeeClient;
import org.opfr.springBootStarterDictionary.models.DictionaryEmployee;
import org.opfr.springbootstarterauthsso.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author 041AlikinOS
 */
@Controller
public class MainController {

    @Autowired
    private JournalStorageRepo journalStorageRepo;
    @Autowired
    private JournalStorageMapper storageMapper;
    @Autowired
    private EmployeeClient employeeClient;
    @Autowired
    private SendMailService sendMailService;
    @Autowired
    private SignStorageService signStorageService;
    @Autowired
    private EditCommentService editCommentService;
    @Autowired
    private JournalStorageService journalStorageService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ModelView modelView;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private SearchService searchService;

    
  @PreAuthorize("principal.orgCode == '041-000-5570' || principal.orgCode == '041-000-4601'")   
  @ExceptionHandler({MyException.class, Exception.class, RuntimeException.class})
  public String handleError(HttpServletRequest req, Exception ex, Model model) {
      
      
    
    UserInfo person = authenticationService.authUser();
    
    
    model.addAttribute("exception", ex);
    model.addAttribute("url", req.getRequestURL());
    model.addAttribute("person", person);
    for(StackTraceElement string : ex.getStackTrace()) {
    SdlasApplication.log.error("User: " + person.getUserCode() + ". Request: " + req.getRequestURL() + " raised " + string);
    }
  
    
    
    
    return "/error";
  }
  
    
    
    @PreAuthorize("principal.orgCode == '041-000-5570' || principal.orgCode == '041-000-4601'")
    @GetMapping("/{storageName}")
    public String ngmd(@PathVariable String storageName, Model model) {

        UserInfo person = authenticationService.authUser();
        List<DictionaryEmployee> emp = employeeClient.getList();
        ModelView view = modelView.getView(storageName);
        List<JournalStorage> journalsStorage = journalStorageRepo.findByStorageStorageType(view.getStorageType());
        List<JournalStorageDto> journalsStorageDto = journalStorageService.listDto(journalsStorage);
        List<JournalStorage> list = journalsStorage.stream().filter(e -> e.isSignEmployee() == false).collect(Collectors.toList());
        List<JournalStorageDto> journalsStorageDtoFilter = journalStorageService.listDto(list);
        model.addAttribute("storageType", view.getStorageType().toString());
        model.addAttribute("person", person);
        model.addAttribute("title", view.getTitle());
        model.addAttribute("path", view.getPath());
        model.addAttribute("name", view.getName());
        model.addAttribute("journalStorageDto", journalsStorageDto);
        model.addAttribute("journalStorageDtoFilter", journalsStorageDtoFilter);
        model.addAttribute("employee", emp);

        return storageName;
    }

    @PreAuthorize("principal.orgCode == '041-000-5570' || principal.orgCode == '041-000-4601'")
    @PostMapping(path = "/{storageName}", consumes = {MediaType.ALL_VALUE})
    public String addHdd(@PathVariable String storageName, JournalStorageDto dto, Map<String, Object> model) throws ParseException, MyException {

        UserInfo person = authenticationService.authUser();
        dto.setEmployeeSecurity(person.getUsername());
        JournalStorage journalStorage = null;
        
        journalStorage = storageMapper.JournalStorageDtoToJournalStorage(dto);
        
        List<DictionaryEmployee> emp = employeeClient.getList();
        ModelView view = modelView.getView(storageName);
        if(!journalStorageRepo.findByStorageNumber(journalStorage.getStorage().getNumber()).isEmpty()) {
            throw new MyException("Устройство с таким учётным номером уже есть в журнале");
        }
        journalStorageRepo.save(journalStorage);
        sendMailService.sendMail(journalStorage);
        List<JournalStorage> journalsStorage = journalStorageRepo.findByStorageStorageType(view.getStorageType());
        List<JournalStorageDto> journalsStorageDto = journalStorageService.listDto(journalsStorage);
        List<JournalStorage> list = journalsStorage.stream().filter(e -> e.isSignEmployee() == false).collect(Collectors.toList());
        List<JournalStorageDto> journalsStorageDtoFilter = journalStorageService.listDto(list);
        model.put("journalStorageDtoFilter", journalsStorageDtoFilter);
        model.put("journalStorageDto", journalsStorageDto);
        model.put("person", person);
        model.put("employee", emp);
        model.put("name", view.getName());
        model.put("path", view.getPath());
        model.put("storageType", view.getStorageType().toString());
        model.put("title", view.getTitle());
        return view.getPath();
    }

    @PreAuthorize("principal.orgCode == '041-000-5570' || principal.orgCode == '041-000-4601'")
    @GetMapping("/main")
    public String main(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        model.addAttribute("person", userDetails);
        return "main";
    }

    @GetMapping("/myaccount")
    public String getData(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        List<JournalStorage> journalsStorage = journalStorageRepo.findByEmployee(userDetails.getUsername());
        List<JournalStorageDto> journalsStorageDto = journalStorageService.listDto(journalsStorage);
        model.addAttribute("title", "Личный кабинет");
        model.addAttribute("journalStorageDto", journalsStorageDto);
        model.addAttribute("person", userDetails);
        return "account";
    }

    @PostMapping("/myaccount")
    public String putSign(SignDto dto, Model model) {
        model.addAttribute("dto", dto);
        signStorageService.signEmpoyeeForStorage(dto);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        List<JournalStorage> journalsStorage = journalStorageRepo.findByEmployee(userDetails.getUsername());
        List<JournalStorageDto> journalsStorageDto = journalStorageService.listDto(journalsStorage);
        model.addAttribute("person", userDetails);
        model.addAttribute("title", "Личный кабинет");
        model.addAttribute("journalStorageDto", journalsStorageDto);

        return "account";
    }

    @PreAuthorize("principal.orgCode == '041-000-5570' || principal.orgCode == '041-000-4601'")
    @PostMapping("/sign")
    public String putSignSecurityWorker(SignDto signDto, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        model.addAttribute("person", userDetails);
        model.addAttribute("dto", signDto);
        signStorageService.signSecurityWorker(signDto);
        return "redirect:/" + signDto.path;
    }

    @PreAuthorize("principal.orgCode == '041-000-5570' || principal.orgCode == '041-000-4601'")
    @PostMapping("/comment")
    public String comment(CommentDto dto, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        model.addAttribute("person", userDetails);
        model.addAttribute("dto", dto);
        editCommentService.editComment(dto);
        return "redirect:/" + dto.path;
    }
    
    @PreAuthorize("principal.orgCode == '041-000-5570' || principal.orgCode == '041-000-4601'")
    @PostMapping("/edit")
    public String editJournal(Long id, JournalStorageDto dto, Model model) throws ParseException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        dto.setEmployeeSecurity(userDetails.getUsername());
        model.addAttribute("person", userDetails);
        journalStorageService.editJournalStorage(dto);

        return "redirect:/ngmd";
    }

    @PreAuthorize("principal.orgCode == '041-000-5570' || principal.orgCode == '041-000-4601'")
    @GetMapping("/edit")
    public String selectJournal(Long id, JournalStorageDto dto, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        JournalStorage journalStorage = journalStorageRepo.findById(id).get();
        JournalStorageDto journalStorageDto = storageMapper.JournalStorageToJournalStorageDto(journalStorage, "yyyy-MM-dd");
        List<DictionaryEmployee> emp = employeeClient.getList();
        String employeeByCode = employeeService.getEmployee(id);
        model.addAttribute("employeeByCode", employeeClient.getEmployeeByCode(employeeByCode));
        model.addAttribute("employee", emp);
        model.addAttribute("title", "Редактирование записи в журнале");
        model.addAttribute("journalStorageDto", journalStorageDto);
        model.addAttribute("person", userDetails);
        return "edit";
    }

    @PreAuthorize("principal.orgCode == '041-000-5570' || principal.orgCode == '041-000-4601'")
    @GetMapping("/delete/{id}")
    public String deleteJournal(@PathVariable Long id, Model model) {

        journalStorageService.deleteJournal(id);
        return "redirect:/ngmd";
    }

    @PreAuthorize("principal.orgCode == '041-000-5570' || principal.orgCode == '041-000-4601'")
    @GetMapping("/search")
    public String search(String request, Model model) {

        UserInfo person = authenticationService.authUser();
        ModelView view = modelView.getView("search");
        List<JournalStorage> searchList = searchService.searchList(request);
        List<JournalStorageDto> journalsStorageDto = journalStorageService.listDto(searchList);
        model.addAttribute("person", person);
        model.addAttribute("journalStorageDto", journalsStorageDto);
        model.addAttribute("path", view.getPath());
        model.addAttribute("name", view.getName());
        model.addAttribute("title", view.getTitle());

        return "search";
    }
   
 
        
}
    
