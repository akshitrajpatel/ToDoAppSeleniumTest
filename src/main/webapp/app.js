document.getElementById('addTaskButton').addEventListener('click', function() {
    const taskText = document.getElementById('taskInput').value;
    if (taskText === '') return;

    const li = document.createElement('li');
    li.textContent = taskText;
    li.addEventListener('click', function() {
        this.classList.toggle('completed');
    });

    document.getElementById('taskList').appendChild(li);
    document.getElementById('taskInput').value = '';
});
