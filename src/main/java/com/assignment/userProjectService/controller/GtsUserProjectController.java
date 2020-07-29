package com.assignment.userProjectService.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.userProjectService.models.GtsUserProjects;
import com.assignment.userProjectService.models.ProjectId;
import com.assignment.userProjectService.models.UserId;
import com.assignment.userProjectService.models.WorkExperienceResponseBody;
import com.assignment.userProjectService.repository.GTS_USER_PROJECT_Repository;

@RestController
public class GtsUserProjectController<T> {
	@Autowired
	private GTS_USER_PROJECT_Repository gtsUserProjectRepository;
	private static final Logger logger = LoggerFactory.getLogger(GtsUserProjectController.class);
	List<GtsUserProjects> projects = new ArrayList();
	@GetMapping("api/v1/user/project/user_id")
	public <T> T getUserProjectsByUserId(@RequestBody UserId userId) {

		Long GTS_USER_ID=userId.getUserId();
		try {
			projects = gtsUserProjectRepository.findBygtsUserId(GTS_USER_ID);
			logger.info("projects are"+projects.toString());
			
			if(projects.isEmpty()){
				logger.error("No Projects for the particular UserId");	
			return (T) new WorkExperienceResponseBody("No Projects for the particular UserId","false",404);	
			
			}
			else{
				return (T) projects;
			}
		} catch (Exception e) {
			logger.error("No Projects for the particular UserId");
			e.printStackTrace();
			return (T) new WorkExperienceResponseBody("No Projects for the particular UserId ","false",404);	
			
		}
		

	}
	@GetMapping("api/v1/user/project/project_id")
	public   <T> T getUserProjectsByWorkExperienceId(@RequestBody ProjectId projectId) {
		

		Optional<GtsUserProjects> gtsUserProject= null;
		try {
			
			gtsUserProject = gtsUserProjectRepository.findById(projectId.getProjectId());
			logger.info("Recieved the UserProject and it is"+gtsUserProject);
		if(gtsUserProject.get()==null){
			logger.error("No Project for the particular ProjectId");
			return (T) new WorkExperienceResponseBody("No Project for the particular ProjectId","false",404);	
			
		}
		else{
			return (T) gtsUserProject;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return (T) new WorkExperienceResponseBody("No Project for the particular ProjectId","false",404);
		}
		

	}

	@PostMapping(path = "api/v1/user/project", consumes = "application/json")
	@ResponseBody
	public  WorkExperienceResponseBody addProject(@RequestBody GtsUserProjects gtsUserProjects) {
		try {
			
			gtsUserProjectRepository.save(gtsUserProjects);
			logger.info("Added new project ");
            return new WorkExperienceResponseBody("Added New Project","true",200);
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception while adding New Project ");
			return new WorkExperienceResponseBody("Exception while adding New Project","false",500);
		}
	}

	@PutMapping(path = "api/v1/user/project", consumes = "application/json")
	public WorkExperienceResponseBody updateProject(@RequestBody GtsUserProjects gtsUserProjects) {
		try {

			gtsUserProjectRepository.save(gtsUserProjects);
			logger.info("Updated the project ");
			return new WorkExperienceResponseBody("updated the Project","true",200);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception while updating the Project");
			return new WorkExperienceResponseBody("exception while updating the Project","false",500);
		}
	}

	@DeleteMapping("api/v1/user/project/project_id")
	public WorkExperienceResponseBody deleteProjectByWorkExperienceId(@RequestBody ProjectId projectId) {
		try {
			
			if((gtsUserProjectRepository.findById(projectId.getProjectId()))==null){
                logger.error("Project doesnot exist for the workExperienceId");
				return new WorkExperienceResponseBody( "Project doesnot exist for the workExperienceId","false",404);}
			else{
				gtsUserProjectRepository.deleteById(projectId.getProjectId());
				logger.info("Deleted the project");
				return new WorkExperienceResponseBody("Deleted the Project","true",200);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception while deleting the Project");
			return new WorkExperienceResponseBody( "Exception while deleting the Project","false",500);
		}
	}
	@DeleteMapping("api/v1/user/project/user_id")
	public WorkExperienceResponseBody deleteProjectsByUserId(@RequestBody UserId userId ) {
	
		Long GTS_USER_ID=userId.getUserId();
			try {projects=gtsUserProjectRepository.findBygtsUserId(GTS_USER_ID);
			
			if(projects.isEmpty()){
				logger.error("project doesn't exist for the userId");
				return new WorkExperienceResponseBody("Project doesnot exist for the UserId", "false",404);}
			
			else{
				gtsUserProjectRepository.deleteBygtsUserId(GTS_USER_ID);
				logger.info("deleted the project");
				return new WorkExperienceResponseBody("Deleted the Project","true",200);		
			}
				
			
			} catch (Exception e) {
				e.printStackTrace();
				return new WorkExperienceResponseBody( "Exception while deleting the Project ","false",500);
				
			
		}
		
		
		
	}
	
	

	
	
	
	
	
}

