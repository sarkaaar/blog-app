import { useEffect, useState } from "react";
import axios from "axios";

export default function Chat_component() {
  const chatMessages = [
    {
      id: 1,
      sender: "me",
      message: "Hey, how are you?",
      timestamp: "2025-01-28T10:15:00Z",
    },
    {
      id: 2,
      sender: "other",
      message: "I'm good, thanks! How about you?",
      timestamp: "2025-01-28T10:16:00Z",
    },
    {
      id: 3,
      sender: "me",
      message: "I'm doing well. What are you up to?",
      timestamp: "2025-01-28T10:17:30Z",
    },
    {
      id: 4,
      sender: "other",
      message: "Just working on a project. How about you?",
      timestamp: "2025-01-28T10:18:45Z",
    },
    {
      id: 5,
      sender: "me",
      message: "Same here! Building a chat application. 😄",
      timestamp: "2025-01-28T10:19:10Z",
    },
    {
      id: 6,
      sender: "other",
      message: "That's awesome! Let me know if you need help.",
      timestamp: "2025-01-28T10:20:00Z",
    },
  ];


  const [message, setMessages] = useState("");
  const [allMessages, setAllMessages] = useState([]);

  const jwt = localStorage.getItem("jwt");

  const sendMessages = async () => {
    console.log("JWT Token:", jwt);
    try {
        const response = await axios.post(
            "http://localhost:8080/api/message/new",
            {
                fromMessage: "username",
                toMessage: "toMessage",
                message: "message",
                status: "SENT"
            },
          {
              headers: { Authorization: `Bearer ${jwt}` }
          })
        console.log("Response:", response.data);
    } catch (error) {
        console.error("Error:", error);
    }
};

  const getAllMessages = async () => {
    console.log("jwt -> " + jwt);
    await axios
      .post("http://localhost:8080/api/message/get", {
        sender: "username",
      },
      {
          headers: { Authorization: `Bearer ${jwt}` }
      })
      .then(function (response) {
        console.log(response);
        setAllMessages([]);
        
      })
      .catch(function (error) {
        console.log(error);
        
      });
  };

  const handleSendingMessages = (event : React.ChangeEvent<HTMLInputElement>) =>{
    setMessages(event.target.value);    
  }

  useEffect(()=>{
    getAllMessages();
  },[])


  return (
    <div className="flex justify-center">
      <div className=" w-3/4">
        <header className="bg-white p-4 text-gray-700">
          <h1 className="text-2xl font-semibold">Alice</h1>
        </header>
        <div className="h-screen overflow-y-auto p-4 pb-36">
          {chatMessages.map((message) => {
            return (
              <>
                {message?.sender !== "me" ? (
                  <div className="flex mb-4 cursor-pointer">
                    <div className="w-9 h-9 rounded-full flex items-center justify-center mr-2">
                      <img
                        src="https://placehold.co/200x/ffa8e4/ffffff.svg?text=ʕ•́ᴥ•̀ʔ&font=Lato"
                        alt="User Avatar"
                        className="w-8 h-8 rounded-full"
                      />
                    </div>
                    <div className="flex max-w-96 bg-white rounded-lg p-3 gap-3">
                      <p className="text-gray-700">{message.message}</p>
                    </div>
                  </div>
                ) : (
                  <div className="flex justify-end mb-4 cursor-pointer">
                    <div className="flex max-w-96 bg-indigo-500 text-white rounded-lg p-3 gap-3">
                      <p>{message.message}</p>
                    </div>
                    <div className="w-9 h-9 rounded-full flex items-center justify-center ml-2">
                      <img
                        src="https://placehold.co/200x/b7a8ff/ffffff.svg?text=ʕ•́ᴥ•̀ʔ&font=Lato"
                        alt="My Avatar"
                        className="w-8 h-8 rounded-full"
                      />
                    </div>
                  </div>
                )}
              </>
            );
          })}
        </div>
      </div>

      <footer className="bg-white border-t border-gray-300 p-4 absolute bottom-0 w-3/4">
        <div className="flex items-center">
          <input
            onChange={(e) =>{handleSendingMessages(e)}}
            type="text"
            placeholder="Type a message..."
            className="w-full p-2 rounded-md border border-gray-400 focus:outline-none focus:border-blue-500"
          />
          <button className="bg-indigo-500 text-white px-4 py-2 rounded-md ml-2" onClick={()=>sendMessages()}>
            Send
          </button>
        </div>
      </footer>
    </div>
  );
}
