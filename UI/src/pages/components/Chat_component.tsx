export default function Chat_component() {


  const chatMessages = [
    {
      "id": 1,
      "sender": "me",
      "message": "Hey, how are you?",
      "timestamp": "2025-01-28T10:15:00Z"
    },
    {
      "id": 2,
      "sender": "other",
      "message": "I'm good, thanks! How about you?",
      "timestamp": "2025-01-28T10:16:00Z"
    },
    {
      "id": 3,
      "sender": "me",
      "message": "I'm doing well. What are you up to?",
      "timestamp": "2025-01-28T10:17:30Z"
    },
    {
      "id": 4,
      "sender": "other",
      "message": "Just working on a project. How about you?",
      "timestamp": "2025-01-28T10:18:45Z"
    },
    {
      "id": 5,
      "sender": "me",
      "message": "Same here! Building a chat application. 😄",
      "timestamp": "2025-01-28T10:19:10Z"
    },
    {
      "id": 6,
      "sender": "other",
      "message": "That's awesome! Let me know if you need help.",
      "timestamp": "2025-01-28T10:20:00Z"
    }
  ]


  return (


    <div className="flex justify-center">
      <footer className="bg-white border-t border-gray-300 p-4 absolute bottom-0 w-3/4">
        <div className="flex items-center">
          <input type="text" placeholder="Type a message..." className="w-full p-2 rounded-md border border-gray-400 focus:outline-none focus:border-blue-500" />
          <button className="bg-indigo-500 text-white px-4 py-2 rounded-md ml-2">Send</button>
        </div>
      </footer>
    </div>
  )
}