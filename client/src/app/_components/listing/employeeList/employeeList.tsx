import React from 'react';
import CardGroup from '../../card/cardGroup';
import BasicCard from '../../card/basicCard';

const employeeList  = ({department, onView}) => {

  // A function to pick a random .svg based on gender



  const cards = department.map((employee, index) => ({
    imageUrl: "/assets/MaleAvatar2.svg",
    title: `${employee.firstName} ${employee.lastName}`,
    subsection: employee.id,
    bodyPart1: employee.gender,
    bodyPart2: employee.role,
  }));
  
  return (
    <div className="">
          <CardGroup cards={cards} />
    </div>
  )
}

export default employeeList