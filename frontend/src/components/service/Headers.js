export const headerPost = (body) => {
    return {
        method: "POST",
        mode: "cors",
        body: JSON.stringify(body),
        headers: {
            "Content-Type": "application/json"
        }
    }
}

export const headerGet = () => {
    return {
        method: "GET",
        mode: "cors",
        headers: {
            "Content-Type": "application/json"
        }
    }
}