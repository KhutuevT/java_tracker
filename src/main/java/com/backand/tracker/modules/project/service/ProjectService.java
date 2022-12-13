package com.backand.tracker.modules.project.service;

import com.backand.tracker.modules.project.Project;
import com.backand.tracker.modules.project.dto.res.ProjectDto;
import com.backand.tracker.modules.user.User;

public interface ProjectService {
    /**
     * Создаёт новый проект.
     *
     * @param name
     * @param descriptions
     * @return
     */
    ProjectDto createNewProject(User user, String name, String descriptions);

    /**
     * Удаляет проект
     *
     * @param projectId
     * @param projectOwnerUserId
     */
    void deleteProject(User user, Long projectId, Long projectOwnerUserId);

    /**
     * Добавить работника в проект.
     *
     * @param projectId
     * @param projectOwnerId
     * @param employeeUserId
     */
    void addEmployeeInProject(User user, Long projectId, Long projectOwnerId, Long employeeUserId);

    /**
     * Удалить работника из проекта.
     *
     * @param projectId
     * @param projectOwnerId
     * @param employeeUserId
     */
    void deleteEmployeeInProject(User user, Long projectId, Long projectOwnerId, Long employeeUserId);

    ProjectDto getById(User user, Long id);

    Project getById(Long id);
}
