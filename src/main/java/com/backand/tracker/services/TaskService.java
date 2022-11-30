package com.backand.tracker.services;

import com.backand.tracker.domains.task.Task;

public interface TaskService {
    /**
     * Создаёт новую таску.
     * @param name
     * @param descriptions
     * @param taskOwnerUserId
     * @return
     */
    Task createNewTask(String name, String descriptions, Long taskOwnerUserId);

    void deleteTask(Long taskOwnerUserId, Long taskId);

    /**
     * Начинает отсчёт времени в таске. Создаёт новый TimeSlice.
      * @param taskId
     * @param taskExecutorUserId - исполнитель таски
     */
    void start(Long taskId, Long taskExecutorUserId);

    /**
     * Останавливает отсчёт времени в таске. Изменяет последний TimeSlice.
     * @param taskId
     * @param taskExecutorUserId - исполнитель таски
     */
    void stop(Long taskId, Long taskExecutorUserId);

    /**
     * Добавляет в таску исполнителя.
     * @param taskId
     * @param taskExecutorUserId - исполнитель таски
     * @param taskOwnerUserId - создатель таски
     */
    void addTaskExecutor(Long taskId, Long taskExecutorUserId, Long taskOwnerUserId);

    /**
     * Владелец таски удаляет исполнителя из таски.
     * @param taskId
     * @param taskExecutorUserId - исполнитель таски
     * @param taskOwnerUserId - создатель таски
     */
    void deleteTaskExecutor(Long taskId, Long taskExecutorUserId, Long taskOwnerUserId);

    /**
     * Исполнитель таски удаляет себя из исполняемых.
     * @param taskId
     * @param taskExecutorUserId - исполнитель таски
     */
    void deleteTaskExecutor(Long taskId, Long taskExecutorUserId);
}
