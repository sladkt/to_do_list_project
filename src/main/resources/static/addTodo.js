document.getElementById("todoForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const title = document.getElementById("title").value;
    const description = document.getElementById("description").value;

    const response = await fetch("/todos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ title, description, completed: false })
    });

    if (response.ok) {
        window.location.href = "/"; // 할 일 목록 페이지로 이동
    } else {
        alert("추가 실패!");
    }
});
