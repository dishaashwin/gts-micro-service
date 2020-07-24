package com.assignment.chaukuriWorkExperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.chaukuriWorkExperience.models.GtsUserProjects;


import java.sql.Date;
import java.util.List;


@Transactional
@Repository
public interface GTS_USER_PROJECT_Repository extends JpaRepository<GtsUserProjects, Long> {



	//List<GTS_USER_WORK_EXPERIENCE> findByTest(Integer test);
	List<GtsUserProjects>findBygtsUserId(Long GTS_USER_ID);
	//List<GTS_USER_WORK_EXPERIENCE> findByGtsUser(Integer gtsUser);

	void deleteBygtsUserId(Long GTS_USER_ID);

	
	
//	@Modifying
//	@Query("UPDATE GTS_USER_WORK_EXPERIENCE wp set wp.GTS_USER_EMPLOYER = :gTS_USER_EMPLOYER,wp.GTS_USER_JOB_DESCRIPTION= :gTS_USER_JOB_DESCRIPTION,wp.GTS_USER_WORK_START_MONTH_YEAR=:gTS_USER_WORK_START_MONTH_YEAR,wp.GTS_USER_WORK_END_MONTH_YEAR=:gTS_USER_WORK_END_MONTH_YEAR,wp.GTS_USER_DESIGNATION=:gTS_USER_DESIGNATION,wp.GTS_USER_PROJECT_SKILL_IDS=:gTS_USER_PROJECT_SKILL_IDS where wp.GTS_USER_WORK_EXPERIENCE_ID = :gTS_USER_WORK_EXPERIENCE_ID")
//	void update(@Param("gTS_USER_WORK_EXPERIENCE_ID") Integer gTS_USER_WORK_EXPERIENCE_ID,@Param("gTS_USER_EMPLOYER") String gTS_USER_EMPLOYER,@Param("gTS_USER_JOB_DESCRIPTION") String gTS_USER_JOB_DESCRIPTION,@Param("gTS_USER_WORK_START_MONTH_YEAR") Date gTS_USER_WORK_START_MONTH_YEAR,@Param("gTS_USER_WORK_END_MONTH_YEAR") Date gTS_USER_WORK_END_MONTH_YEAR,@Param("gTS_USER_DESIGNATION")String gTS_USER_DESIGNATION,@Param("gTS_USER_PROJECT_SKILL_IDS") String gTS_USER_PROJECT_SKILL_IDS);

//	@Modifying
//	@Query("SELECT * FROM  GTS_USER_WORK_EXPERIENCE wp where wp.GTS_USER_WORK_EXPERIENCE_ID = 5")
//	List<GTS_USER_WORK_EXPERIENCE> findByUserId(@Param("GTS_USER_ID") Integer GTS_USER_ID);


	
}
