package com.backand.tracker.services;

import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.user.User;

public interface ProjectService {
    /**
     * Создаёт новый проект.
     * @param name
     * @param descriptions
     * @return
     */
    Project createNewProject(User user, String name, String descriptions);

    /**
     * Удаляет проект
     * @param projectId
     * @param projectOwnerUserId
     */
    void deleteProject(User user, Long projectId, Long projectOwnerUserId);

    /**
     * Добавить работника в проект.
     * @param projectId
     * @param projectOwnerId
     * @param employeeUserId
     */
    void addEmployeeInProject(User user, Long projectId, Long projectOwnerId, Long employeeUserId);

    /**
     * Удалить работника из проекта.
     * @param projectId
     * @param projectOwnerId
     * @param employeeUserId
     */
    void deleteEmployeeInProject(User user, Long projectId, Long projectOwnerId, Long employeeUserId);

    Project getById(User user, Long id);
}
