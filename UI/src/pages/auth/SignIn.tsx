import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import axios from "axios";
import Navbar from "../components/Navbar"

export default function SignIn() {
  const navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const login = async () => {
    await axios
      .post("http://localhost:8080/api/auth/sign-in", {
        username: email,
        password: password,
      })
      .then(function (response) {
        console.log(response.data);
        alert("login success!!!")
        localStorage.setItem("jwt", response.data);
        localStorage.setItem("username", email);
        navigate("/messages");
      })
      .catch(function (error) {
        alert("unable to login!!!")
        console.log(error);
      });
  };

  return (
    <>
      <Navbar />
      <div className=" flex justify-center mt-48">
        <div className="w-fit bg-slate-50 rounded-xl min-h-full py-12 px-4 sm:px-6 lg:px-8">
          <div className="max-w-md w-full space-y-8">
            <div>
              <img
                className="mx-auto h-12 w-auto"
                src="https://tailwindui.com/img/logos/workflow-mark.svg?color=indigo&shade=600"
                alt="Workflow"
              />
              <h2 className="mt-6 text-center text-3xl tracking-tight font-bold text-gray-900">
                Sign in to your account
              </h2>
            </div>
            {/* <form className="mt-8 space-y-6" action="login" method="POST"> */}
            <div className="rounded-md shadow-sm -space-y-px">
              <input
                id="email-address"
                name="email"
                type="email"
                autoComplete="email"
                required
                value={email}
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
                className="mb-2 appearance-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                placeholder="Email address"
              />
              <input
                id="password"
                name="password"
                type="password"
                autoComplete="current-password"
                required
                value={password}
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
                className="appearance-none rounded-md relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900  focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                placeholder="Password"
              />
            </div>

            <div className="flex items-center justify-between">
              <div className="flex items-center">
                <input
                  id="remember-me"
                  name="remember-me"
                  type="checkbox"
                  className="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded"
                />
                <label
                  htmlFor="remember-me"
                  className="ml-2 block text-sm text-gray-900"
                >
                  Remember me
                </label>
              </div>

              <div className="text-sm">
                <Link
                  to="/sign-up"
                  className="font-medium text-indigo-600 hover:text-indigo-500"
                >
                  Don't have an account?
                </Link>
              </div>
            </div>
            <div>
              <button
                type="submit"
                onClick={login}
                className="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
              >
                <span className="absolute left-0 inset-y-0 flex items-center pl-3"></span>
                Sign in
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
