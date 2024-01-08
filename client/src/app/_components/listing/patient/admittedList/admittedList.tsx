import React from 'react'



const AdmittedList = ({department, onDischarge, onView}) => {
  
  return (
    <div className="max-h-64 overflow-y-auto">
      <table className="table-auto w-full border border-secondary rounded-2xl">
        <thead className='bg-secondary'>
          <tr>
            <th className="py-2 px-4 border-b border-2 border-gray-700">ID</th>
            <th className="py-2 px-4 border-b border-2 border-gray-700">Name</th>
            <th className="py-2 px-4 border-b border-2 border-gray-700">Age</th>
            <th className="py-2 px-4 border-b border-2 border-gray-700">Bed</th>
            <th className="py-2 px-4 border-b border-2 border-gray-700">Admitted Time</th>
            <th className="py-2 px-4 border-b border-2 border-gray-700">Actions</th>
          </tr>
        </thead>
        <tbody>

          {/* Add later */}
          {/* {department.map((patient,index) => ( */}
            {/* <tr key={index}> */}
            <tr>
              <td className="py-6 px-4 border-2 border-gray-700 text-center">1233</td>
              <td className="py-6 px-4 border-2 border-gray-700 text-center">Michias Shiferaw</td>
              <td className="py-6 px-4 border-2 border-gray-700 text-center">31</td>
              <td className="py-6 px-4 border-2 border-gray-700 text-center">123</td>
              <td className="py-6 px-4 border-2 border-gray-700 text-center">11/12/23</td>
              <td className="py-2 px-4 border-2 text-center border-gray-700">
                <button 
                onClick={() => onDischarge("patient.id")}
                 className="mr-1 bg-blue-500 px-6 p-1 text-gray-50 duration-150 hover:!border-b-2  rounded-xl drop-shadow-lg items-center border-2 border-b-4 border-blue-950 cursor-pointer active:bg-blue-400">
                  Discharge
                </button>
                <button 
                onClick={() => onView("patient.id")} 
                className="mx-1 px-6 bg-secondary p-1 duration-150 hover:!border-b-2 text-blue-900 rounded-xl drop-shadow-lg items-center border-2 border-b-4 border-blue-950 cursor-pointer active:bg-yellow-400">
                  View File
                </button>
              </td>
            </tr>
          {/* ))} */}
        </tbody>
      </table>
    </div>
  )
}

export default AdmittedList