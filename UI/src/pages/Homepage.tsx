import Navbar from "./components/Navbar";
import Chat_component from "./components/Chat_component";


export default function Homepage() {
  return (
    <div>
      <Navbar />
      <h1>This is the homepage</h1>

      <div className="flex justify-center">
        <textarea className="border-2 border-emerald-800 w-96" />
        <button className="border-2 border-emerald-800">Send</button>
      </div>


      <div>
        <h1>Thread</h1>
      </div>

      <Chat_component />

    </div>
  );
}
