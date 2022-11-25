package com.backand.tracker.services;

import com.backand.tracker.domains.Project;

public interface ProjectService {
    /**
     * Создаёт новый проект.
     * @param name
     * @param descriptions
     * @param projectOwnerUserId
     * @return
     */
    Project createNewProject(String name, String descriptions, Long projectOwnerUserId);

    /**
     * Удаляет проект
     * @param projectId
     * @param projectOwnerUserId
     */
    void deleteProject(Long projectId, Long projectOwnerUserId);

    /**
     * Добавить работника в проект.
     * @param projectId
     * @param projectOwnerId
     * @param employeeUserId
     */
    void addEmployeeInProject(Long projectId, Long projectOwnerId, Long employeeUserId);

    /**
     * Удалить работника из проекта.
     * @param projectId
     * @param projectOwnerId
     * @param employeeUserId
     */
    void deleteEmployeeInProject(Long projectId, Long projectOwnerId, Long employeeUserId);
}
