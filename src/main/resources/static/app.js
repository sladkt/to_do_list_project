// 페이지 로드 시 Todo 목록을 불러오는 함수
function loadTodos() {
    fetch('https://jubilant-goldfish-rjppgj97ggvh446-8080.app.github.dev/todos')  // 백엔드에서 Todo 목록을 가져옴
        .then(response => response.json())
        .then(todos => {
            const tableBody = document.querySelector('#todoTable tbody');
            tableBody.innerHTML = ''; // 기존 내용을 지운 후 새로운 데이터 추가

            todos.forEach(todo => {
                const row = document.createElement('tr');

                // Title
                const titleCell = document.createElement('td');
                titleCell.textContent = todo.title;
                row.appendChild(titleCell);

                // Description
                const descCell = document.createElement('td');
                descCell.textContent = todo.description;
                row.appendChild(descCell);

                // Completed
                const completedCell = document.createElement('td');
                completedCell.textContent = todo.completed ? 'Yes' : 'No';
                row.appendChild(completedCell);

                // Actions
                const actionsCell = document.createElement('td');
                actionsCell.innerHTML = `
                    <button onclick="deleteTodo(${todo.id})">Delete</button>
                    <button onclick="editTodo(${todo.id})">Edit</button>
                `;
                row.appendChild(actionsCell);

                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error:', error));
}

// 새로운 Todo 추가하는 함수
document.querySelector('#todoForm').addEventListener('submit', function (event) {
    event.preventDefault();  // 폼 제출 후 페이지 리로드 방지

    const title = document.querySelector('#title').value;
    const description = document.querySelector('#description').value;

    const newTodo = {
        title: title,
        description: description,
        completed: false
    };

    fetch('https://jubilant-goldfish-rjppgj97ggvh446-8080.app.github.dev/todos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newTodo)
    })
    .then(response => response.json())
    .then(() => {
        loadTodos();  // Todo 목록을 다시 불러와서 갱신
        document.querySelector('#title').value = '';  // 입력창 초기화
        document.querySelector('#description').value = '';
    })
    .catch(error => console.error('Error:', error));
});

// Todo 삭제하는 함수
function deleteTodo(id) {
    fetch(`https://jubilant-goldfish-rjppgj97ggvh446-8080.app.github.dev/todos/${id}`, {
        method: 'DELETE'
    })
    .then(() => {
        loadTodos();  // Todo 목록을 다시 불러와서 갱신
    })
    .catch(error => console.error('Error:', error));
}

// Todo 수정하는 함수 (단순 예시, 입력 폼을 만들어야 할 수도 있음)
function addTodo() {
    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;
    const completed = document.getElementById('completed').checked;

    const newTodo = {
        title: title,
        description: description,
        completed: completed
    };

    fetch('https://jubilant-goldfish-rjppgj97ggvh446-8080.app.github.dev/todos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newTodo)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Todo added:', data);
        // 새로 추가된 Todo를 화면에 반영하는 로직을 추가할 수 있음
    })
    .catch(error => {
        console.error('Error:', error);
    });
}


// 처음 페이지 로드 시 Todo 목록을 불러옴
loadTodos();
