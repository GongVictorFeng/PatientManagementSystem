import Link from "next/link";
import React from "react";

const RequestList = ({ department, onAdmit, onView, onRemove }) => {
  
  
  // remove for later
  department = [
    { id: 1, name: "John Doe", severity: "Critical" },
    { id: 2, name: "Jane Doe", severity: "Moderate" },

  ];
  return (
    <div className="max-h-64 overflow-y-auto">
      <table className="table-auto w-full border border-secondary rounded-2xl">
        <thead className="bg-secondary">
          <tr>
            <th className="py-2 px-4 border-b border-2 border-gray-700">ID</th>
            <th className="py-2 px-4 border-b border-2 border-gray-700">
              Name
            </th>
            <th className="py-2 px-4 border-b border-2 border-gray-700">
              Condition
            </th>
            <th className="py-2 px-4 border-b border-2 border-gray-700">
              Actions
            </th>
          </tr>
        </thead>
        <tbody>
          {/* Add later */}
          {department.map((patient, index) => (
            <tr key={index}>
              <td className="py-6 px-4 border-2 border-gray-700 text-center">
                {patient.id}
              </td>
              <td className="py-6 px-4 border-2 border-gray-700 text-center">
                {patient.name}
              </td>
              <td className="py-6 px-4 border-2 border-gray-700 text-center">
                {patient.severity}
              </td>
              <td className="py-2 px-0 border-2 text-center border-gray-700">
                <Link
                  href={{
                    pathname: "admitPatient",
                    query: { patientId: patient.id },
                  }}
                  onClick={() => onAdmit("patient.id")}
                  className="mr-1 px-6 bg-blue-500 p-1 duration-150 hover:!border-b-2 text-gray-50 rounded-xl drop-shadow-lg items-center border-2 border-b-4 border-blue-950 cursor-pointer active:bg-blue-400"
                >
                  Admit
                </Link>
                <Link
                  href={{
                    pathname: "/123/view",
                    query: { patientId: patient.id },
                  }}
                  onClick={() => onView("patient.id")}
                  className="mx-1 px-6 bg-secondary p-1 duration-150 hover:!border-b-2 text-black rounded-xl drop-shadow-lg items-center border-2 border-b-4 border-blue-950 cursor-pointer active:bg-yellow-400"
                >
                  View File
                </Link>
                <button
                  onClick={() => onRemove("patient.id")}
                  className=" ml-1 px-6 transition ease-in duration-300 shadow-sm hover:shadow-lg tracking-wider bg-red-500 py-1 hover:!border-b-2 text-gray-50 rounded-xl drop-shadow-lg items-center border-2 border-b-4 border-blue-950 cursor-pointer active:bg-red-400"
                >
                  Remove
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default RequestList;
