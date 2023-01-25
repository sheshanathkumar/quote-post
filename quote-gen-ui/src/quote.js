import React, { useEffect, useState } from "react";
import "./quote-style.css"


export default function Quote(props) {


    const [quote, setQuot] = useState();

    const getQuotes = () => {
        fetch("/api/get-quote?id=3").then((response) => {

            response.json().then((resp) => {
                setQuot(resp)
            });
        });
    };

    useEffect(() => {
        getQuotes()
    }, [])

    console.log(quote)
    console.log("api ends here")
    let content = "Awating Response...."
    let author = "..."
    let user = "..."
    let username = "..."
    var img = ""

    if (quote != null) {
        content = quote.body.quote;
        author = quote.body.author;
        img = quote.body.image;
        user = quote.body.name;
        username = quote.body.username;
    }

    console.log(img)


    return (
        <>

            <div className="quote-card">

                <div className="header">
                    <img className="image"
                        //src="https://opensource.fb.com/img/projects/react.jpg"
                        src = {require('./person.jpg')}
                        alt="" />

                    <div className="userintro">
                        <p className="user">{user}</p>
                        <p className="userid">{username}</p>
                    </div>

                </div>
                <div className="content"> <p> {content}  </p> </div>
                <div className="author">{author}</div>
            </div>
        </>
    );


}