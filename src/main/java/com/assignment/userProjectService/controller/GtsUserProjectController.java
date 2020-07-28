package com.assignment.userProjectService.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	
	List<GtsUserProjects> workExperiences = new ArrayList();
	@GetMapping("api/v1/user/project/user_id")
	public <T> T getUserProjectsByUserId(@RequestBody UserId userId) {

		Long GTS_USER_ID=userId.getUserId();
		try {
			workExperiences = gtsUserProjectRepository.findBygtsUserId(GTS_USER_ID);
			
			if(workExperiences.isEmpty()){
			return (T) new WorkExperienceResponseBody("No Projects for the particular UserId","false",404);	
			}
			else{
				return (T) workExperiences;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return (T) new WorkExperienceResponseBody("No Projects for the particular UserId ","false",404);	
			
		}
		

	}
	@GetMapping("api/v1/user/project/project_id")
	public   <T> T getUserProjectsByWorkExperienceId(@RequestBody ProjectId projectId) {
		

		Optional<GtsUserProjects> gtsUserProject= null;
		try {
			
			gtsUserProject = gtsUserProjectRepository.findById(projectId.getProjectId());
		if(gtsUserProject.get()==null){
			return (T) new WorkExperienceResponseBody("No Project for the particular WorkExperienceId","false",404);	
			
		}
		else{
			return (T) gtsUserProject;
		}
		} catch (Exception e) {
			e.printStackTrace();
			return (T) new WorkExperienceResponseBody("No Project for the particular WorkExperienceId","false",404);
		}
		

	}

	@PostMapping(path = "api/v1/user/project", consumes = "application/json")
	@ResponseBody
	public  WorkExperienceResponseBody addProject(@RequestBody GtsUserProjects gtsUserProjects) {
		try {
			
			gtsUserProjectRepository.save(gtsUserProjects);
			
            return new WorkExperienceResponseBody("Added New Project","true",200);
		
		} catch (Exception e) {
			e.printStackTrace();
			
			return new WorkExperienceResponseBody("Exception while adding New Project","false",500);
		}
	}

	@PutMapping(path = "api/v1/user/project", consumes = "application/json")
	public WorkExperienceResponseBody updateProject(@RequestBody GtsUserProjects gtsUserProjects) {
		try {

			gtsUserProjectRepository.save(gtsUserProjects);
			return new WorkExperienceResponseBody("updated the Project","true",200);
		} catch (Exception e) {
			e.printStackTrace();
			return new WorkExperienceResponseBody("exception while updating the Project","false",500);
		}
	}

	@DeleteMapping("api/v1/user/project/project_id")
	public WorkExperienceResponseBody deleteProjectByWorkExperienceId(@RequestBody ProjectId projectId) {
		try {
			
			if((gtsUserProjectRepository.findById(projectId.getProjectId()))==null){

				return new WorkExperienceResponseBody( "Project doesnot exist for the workExperienceId","false",404);}
			else{
				gtsUserProjectRepository.deleteById(projectId.getProjectId());
				return new WorkExperienceResponseBody("Deleted the Project","true",200);		
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new WorkExperienceResponseBody( "Exception while deleting the Project","false",500);
		}
	}
	@DeleteMapping("api/v1/user/project/user_id")
	public WorkExperienceResponseBody deleteProjectsByUserId(@RequestBody UserId userId ) {
	
		Long GTS_USER_ID=userId.getUserId();
			try {workExperiences=gtsUserProjectRepository.findBygtsUserId(GTS_USER_ID);
			
			if(workExperiences.isEmpty()){
				return new WorkExperienceResponseBody("Project doesnot exist for the UserId", "false",404);}
			else{
				gtsUserProjectRepository.deleteBygtsUserId(GTS_USER_ID);
				return new WorkExperienceResponseBody("Deleted the Project","true",200);		
			}
				
			
			} catch (Exception e) {
				e.printStackTrace();
				return new WorkExperienceResponseBody( "Exception while deleting the Project ","false",500);
				
			
		}
		
		
		
	}
	
	

	
	
	
	
	
}

